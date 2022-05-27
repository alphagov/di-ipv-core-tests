package gov.di_ipv_core.step_definitions;

import gov.di_ipv_core.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;

public class Hooks {

    @Before("@integration_test")
    public void clearS3Bucket(){
        final String BUCKET_NAME = "staging-smoke-test-sms-codes";
        final String OBJECT_NAME = "+447700900222";
        S3Client s3Client = S3Client.builder().region(Region.EU_WEST_2).build();
        s3Client.deleteObject(DeleteObjectRequest
                .builder()
                .bucket(BUCKET_NAME)
                .key(OBJECT_NAME)
                .build());

    }
    @After ("@integration_test")
    public void tearDown() {
        final String BUCKET_NAME = "staging-smoke-test-sms-codes";
        final String OBJECT_NAME = "+447700900222";
        S3Client s3Client = S3Client.builder().region(Region.EU_WEST_2).build();
        s3Client.deleteObject(DeleteObjectRequest
                .builder()
                .bucket(BUCKET_NAME)
                .key(OBJECT_NAME)
                .build());
    }

    @AfterAll
    public  static void quitDriver() {
                Driver.closeDriver();

    }
}
