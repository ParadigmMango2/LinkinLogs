module "nginx" {
  source = "./modules/nginx"
  name = "nginx-test"
  replicas = 2
}

module "postgres-jenkins" {
  source = "./modules/postgres"
  name = "postgres-jenkins"
  namespace = "jenkins-ns"
}
