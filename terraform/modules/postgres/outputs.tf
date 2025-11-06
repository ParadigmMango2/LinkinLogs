output "postgres_service_ip" {
  # data source declared in secrets.tf
  value = data.kubernetes_service.postgres_svc.spec[0].cluster_ip
}
