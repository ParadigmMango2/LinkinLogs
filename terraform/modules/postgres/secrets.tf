data "kubernetes_service" "postgres_svc" {
  metadata {
    name = "${var.name}-postgresql"
    namespace = var.namespace
  }
}

resource "kubernetes_secret" "postgres" {
  metadata {
    name = "${var.name}-credentials"
    namespace = var.namespace
  }

  data = {
    username = var.postgres_user
    password = var.postgres_password
    database = var.postgres_db
    host = data.kubernetes_service.postgres_svc.spec[0].cluster_ip
  }

  type = "Opaque"
}
