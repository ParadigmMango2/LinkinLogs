resource "kubernetes_secret" "postgres" {
  metadata {
    name = "${var.name}-credentials"
    namespace = var.namespace
  }

  data = {
    username = var.postgres_user
    password = var.postgres_password
    database = var.postgres_db
  }

  type = "Opaque"
}
