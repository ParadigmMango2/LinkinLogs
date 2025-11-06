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
  admin_password = var.jenkins_db_admin_password
  postgres_user = "jenkins-user"
  postgres_password = var.jenkins_db_password
  postgres_db = "jenkins-db"
  depends_on = [ minikube_cluster.docker ]
}

module "jenkins" {
  source = "./modules/jenkinswatcher"
  replicas = 2
  pg_secret = module.postgres-jenkins.pg_secret
  depends_on = [ minikube_cluster.docker, module.postgres-jenkins.pg_secret ]
}
