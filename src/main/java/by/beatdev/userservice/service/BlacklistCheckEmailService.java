package by.beatdev.userservice.service;

import by.beatdev.userservice.exception.custom.UserEmailInBlacklistException;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Described class is a stub for simulating a call to external API.
 * It represents the email blacklist check. A delay of 5-10 seconds is set according to the technical task.
 * Returns a random value.
 */
@Service
public class BlacklistCheckEmailService implements IBlacklistCheckEmailService {

    public static final int LOWER_DELAY_BOUND = 5;
    public static final int UPPER_DELAY_BOUND = 11;

    @Override
    public boolean check(String email) {
        try {
            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
            TimeUnit.SECONDS.sleep(threadLocalRandom.nextInt(LOWER_DELAY_BOUND, UPPER_DELAY_BOUND));
            if (threadLocalRandom.nextBoolean()) {
                throw new UserEmailInBlacklistException("Email is blacklisted");
            }
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
