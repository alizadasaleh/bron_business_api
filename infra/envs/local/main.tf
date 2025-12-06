module "bron_stack" {
  source      = "../../modules/bron_stack"
  bucket_name = var.bucket_name
  environment = "local"
}