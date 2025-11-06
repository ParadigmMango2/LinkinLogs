output "postgres_service_ip" {
  # data source declared in secrets.tf
  value = data.kubernetes_service.postgres_svc.spec[0].cluster_ip
}

output "pg_secret" {
  value = kubernetes_secret.postgres
  sensitive = true
}
