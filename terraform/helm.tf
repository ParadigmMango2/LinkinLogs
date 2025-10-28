resource "helm_release" "postgres" {
  name       = "postgres-jenkins"
  repository = "https://charts.bitnami.com/bitnami"
  chart      = "postgresql"
  namespace  = "jenkins-ns"
}
