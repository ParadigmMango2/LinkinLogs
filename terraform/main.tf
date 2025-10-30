/*
module "nginx" {
  source = "./modules/nginx"
  name = "nginx-test"
  replicas = 2
}
*/

module "postgres-jenkins" {
  source = "./modules/postgres"
  name = "postgres-jenkins"
  namespace = "jenkins-ns"
  postgres_user = "jenkins-user"
  postgres_password = var.jenkins_db_password
  postgres_db = "jenkins-db"
}
