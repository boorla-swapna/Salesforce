package constants;

import java.time.Duration;

import dev.failsafe.internal.util.Durations;

public class WaitConstants {

	public static final Duration IMPLICIT_WAIT_DURATION=Duration.ofSeconds(50);
	public static final Duration ELEMENT_TO_BE_CLICKABLE=Duration.ofSeconds(30);
	public static final Duration WAIT_FOR_ELEMENT_TO_BE_VISIBLE=Duration.ofSeconds(50);
	public static final Duration WAIT_FOR_ELEMENT_TO_DISAPPEAR=Duration.ofSeconds(30);
}
