package org.springframework.xd.videoanalyzer;

import org.springframework.integration.endpoint.EventDrivenConsumer;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;

/**
 * 
 * @author Ilayaperumal Gopinathan
 */
public class VideoAnalyzerModule extends EventDrivenConsumer {

	public VideoAnalyzerModule(SubscribableChannel inputChannel,
			MessageHandler handler) {
		super(inputChannel, handler);
	}
}
