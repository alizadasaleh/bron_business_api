package az.bron.business.config;

import com.amazonaws.services.s3.AmazonS3;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Log4j2
public class S3Service {

    private final AmazonS3 s3client;

    @Value("${aws.bucket.name}")
    private String bucketName;

    @Value("${aws.bucket.url}")
    private String bucketUrl;


    public S3Service(AmazonS3 s3client) {
        this.s3client = s3client;
    }


    public String uploadFile(String keyName, MultipartFile file, String directory) throws IOException {
        String fullFilePath = directory + keyName;
        var putObjectResult = s3client.putObject(bucketName, fullFilePath, file.getInputStream(), null);
        log.info(putObjectResult.getMetadata());
        String url = bucketUrl + fullFilePath;
        return url;
    }


}