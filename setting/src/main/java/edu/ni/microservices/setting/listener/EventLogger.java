package edu.ni.microservices.setting.listener;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author GGIB
 */
@Slf4j
public class EventLogger implements CacheEventListener<Object, Object> {

	public void onEvent(CacheEvent<? extends Object, ? extends Object> event) {
		log.info("\nListener");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n === Event: ");
		stringBuilder.append(event.getType());
		stringBuilder.append(" Key: ");
		stringBuilder.append(event.getKey());
		stringBuilder.append(" old value: ");
		stringBuilder.append(event.getOldValue());
		stringBuilder.append(" new value: ");
		stringBuilder.append(event.getNewValue());
		log.info(stringBuilder.toString());

	}

}