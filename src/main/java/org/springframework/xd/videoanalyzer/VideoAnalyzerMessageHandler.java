package org.springframework.xd.videoanalyzer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.springframework.integration.handler.AbstractReplyProducingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author Ilayaperumal Gopinathan
 * 
 */
public class VideoAnalyzerMessageHandler extends
		AbstractReplyProducingMessageHandler {

	@Override
	protected Object handleRequestMessage(Message<?> requestMessage) {
		ByteArrayInputStream in = new ByteArrayInputStream(
				(byte[]) requestMessage.getPayload());
		ObjectInputStream is = null;
		IplImage img = null;
		try {
			is = new ObjectInputStream(in);
			img = (IplImage) is.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return MessageBuilder.withPayload(img.sizeof()).build();
	}
}
