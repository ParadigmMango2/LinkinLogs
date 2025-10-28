output "minikube_host" {
  value       = minikube_cluster.docker.host
  description = "API server host (https://host:8443) from the minikube provider"
}
