package edu.ndsi.microservices.news.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@SequenceGenerator(name = "SEQ_ARTICLE", allocationSize = 1, initialValue = 1)

@SecondaryTables({
		@SecondaryTable(name = "article_content", pkJoinColumns = {
				@PrimaryKeyJoinColumn(name = "article_id", referencedColumnName = "id") }),
		@SecondaryTable(name = "article_images", pkJoinColumns = {
				@PrimaryKeyJoinColumn(name = "article_id", referencedColumnName = "id") }), })

public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ARTICLE")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("articles")
	@ToString.Exclude
	private Author author;

	@Future
	private Date publishDate;
	private boolean approved;

	@Size(max = 100, min = 10)
	@NotBlank // used for string
	private String title;

	@Lob
	@Column(table = "article_content")
	@Basic(fetch = FetchType.LAZY)
	private String content; // lob + string fiels = Clob

	@Lob
	@Column(table = "article_images")
	@Basic(fetch = FetchType.LAZY)
	private Byte[] mainImage; // lob+ array of bytes = Blob

	@ElementCollection
	@Column(name = "tag")
	@CollectionTable(uniqueConstraints = @UniqueConstraint(columnNames = { "article_id", "tag" }))
	private Set<String> tags;

}
