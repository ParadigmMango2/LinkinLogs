data "kubernetes_service" "postgres_svc" {
  metadata {
    name = "${var.name}-postgresql"
    namespace = var.namespace
  }

  depends_on = [ helm_release.postgres ]
}

# For import to spring boot pod shell environments
resource "kubernetes_secret" "postgres" {
  metadata {
    name = "${var.name}-credentials"
    namespace = var.namespace
  }

  data = {
    DB_USER = var.postgres_user
    DB_PASSWORD = var.postgres_password
    DB_NAME = var.postgres_db
    DB_HOST = data.kubernetes_service.postgres_svc.spec[0].cluster_ip
  }

  type = "Opaque"
}
