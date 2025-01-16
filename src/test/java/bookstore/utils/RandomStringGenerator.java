package bookstore.utils;

import java.time.Instant;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomStringGenerator {

    public static String generateRandomString(int length) {
        org.apache.commons.text.RandomStringGenerator alfaNumericGenerator =
                new org.apache.commons.text.RandomStringGenerator.Builder().withinRange('a', 'z').build();
        return alfaNumericGenerator.generate(length);
    }

    public static String generateUniquePhoneNumber(int lengthOfPhoneNumber) {
        return "0"
                + IntStream.range(0, lengthOfPhoneNumber - 1) // -1 because it already contains "0"
                .mapToObj(i -> String.valueOf(new Random().nextInt(10)))
                .collect(Collectors.joining(""));
    }

    public static String generateUniqueEmail() {
        int minStringLength = 5;
        int maxStringLength = 20;
        String[] domains = {"@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com"};
        long timestamp = Instant.now().toEpochMilli();

        return generateRandomString(new Random().nextInt(minStringLength, maxStringLength))
                + timestamp
                + domains[new Random().nextInt(domains.length)];
    }
}
