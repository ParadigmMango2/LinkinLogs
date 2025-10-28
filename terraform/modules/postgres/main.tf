resource "helm_release" "postgres" {
  name       = var.name
  repository = "https://charts.bitnami.com/bitnami"
  chart      = "postgresql"
  namespace  = var.namespace
}
