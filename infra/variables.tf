variable "aws_region" {
  default = "eu-central-1"
}

variable "bucket_name" {
  default = "bron_s3"
  description = "BRON_S3"
  type        = string
}
