module "nginx" {
  source   = "./modules/nginx"
  name     = "nginx-test"
  replicas = 2
}
