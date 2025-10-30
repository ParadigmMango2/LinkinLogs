resource "helm_release" "postgres" {
  name = var.name
  repository = "https://charts.bitnami.com/bitnami"
  chart = "postgresql"
  namespace = var.namespace

  values = [
    templatefile("${path.module}/values.tpl.yaml", {
      postgres_user = "jenkins_user"
      postgres_password = "example"
      postgres_db = "jenkins_db"
    })
  ]
}
