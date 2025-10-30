resource "helm_release" "postgres" {
  name = var.name
  repository = "https://charts.bitnami.com/bitnami"
  chart = "postgresql"
  namespace = var.namespace

  values = [
    templatefile("${path.module}/values.tpl.yaml", {
      postgres_user = var.postgres_user
      postgres_password = var.postgres_password
      postgres_db = var.postgres_db
    })
  ]
}
