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
  namespace = "jenkins-ns"
  pg_secret = module.postgres-jenkins.pg_secret
  jenkins_protocol = var.jenkins_protocol
  jenkins_url = var.jenkins_url
  jenkins_port = var.jenkins_port
  jenkins_user = var.jenkins_user
  jenkins_token = var.jenkins_token
  depends_on = [ minikube_cluster.docker, module.postgres-jenkins.pg_secret ]
}
