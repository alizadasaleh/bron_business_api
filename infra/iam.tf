resource "aws_iam_policy" "s3_write_policy" {
  name        = "app-write-images-policy"
  description = "Allow BRON API to upload/delete objects"

  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Effect   = "Allow"
        Action   = [
          "s3:PutObject",
          "s3:DeleteObject"
        ]
        Resource = "${aws_s3_bucket.bron_bucket.arn}/*"
      }
    ]
  })
}
