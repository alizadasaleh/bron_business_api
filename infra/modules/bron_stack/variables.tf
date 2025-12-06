variable "bucket_name" {
  default = "brons3"
  description = "BRON_S3"
  type        = string
}

variable "environment" {
  type        = string
  default = "local"
  description = "Environment label (local/dev)"
}
