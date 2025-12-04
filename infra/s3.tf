resource "aws_s3_bucket" "bron_bucket" {
  bucket = var.bucket_name

  force_destroy = false
  tags = {
    Name = "BronBucket"
    app = "bron_aws"
    Environment = "Dev"
  }
}

resource "aws_s3_bucket_public_access_block" "bron_bucket" {
  bucket                  = aws_s3_bucket.bron_bucket.id
  block_public_acls       = true
  block_public_policy     = false
  ignore_public_acls      = true
  restrict_public_buckets = false
}

resource "aws_s3_bucket_policy" "public_read" {
  bucket = aws_s3_bucket.bron_bucket.id

  policy = jsonencode({
    Version = "2012-10-17",
    Statement = [
      {
        Sid       = "PublicRead"
        Effect    = "Allow"
        Principal = "*"
        Action    = [
          "s3:GetObject"
        ]
        Resource = "${aws_s3_bucket.bron_bucket.arn}/*"
      }
    ]
  })
}

resource "aws_iam_user" "app_user" {
  name = "bron-api-user"
}

resource "aws_iam_user_policy_attachment" "app_user_attach" {
  user       = aws_iam_user.app_user.name
  policy_arn = aws_iam_policy.s3_write_policy.arn
}

resource "aws_iam_access_key" "app_user_keys" {
  user = aws_iam_user.app_user.name
}


