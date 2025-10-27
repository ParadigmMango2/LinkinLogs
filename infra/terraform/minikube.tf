resource "minikube_cluster" "docker" {
  driver       = "docker"
  cluster_name = "tf-minikube-cluster"
  addons = [
    "default-storageclass",
    "storage-provisioner"
  ]
}
