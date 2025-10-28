terraform {
  required_providers {
    minikube = {
      source = "scott-the-programmer/minikube"
      version = "0.6.0"
    }
    kubernetes = {
      source = "hashicorp/kubernetes"
      version = "2.38.0"
    }
    helm = {
      source = "hashicorp/helm"
      version = "3.1.0"
    }
  }
}

provider "minikube" {
  # Configuration options
}

# Used after cluster is initialized
provider "kubernetes" {
  host = minikube_cluster.docker.host
  client_certificate = minikube_cluster.docker.client_certificate
  client_key = minikube_cluster.docker.client_key
  cluster_ca_certificate = minikube_cluster.docker.cluster_ca_certificate
}

provider "helm" {
  kubernetes = {
    host = minikube_cluster.docker.host
    client_certificate = minikube_cluster.docker.client_certificate
    client_key = minikube_cluster.docker.client_key
    cluster_ca_certificate = minikube_cluster.docker.cluster_ca_certificate
  }
}
