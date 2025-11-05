resource "null_resource" "build_and_load_image" {
  triggers = {
    src_hash = sha1(
      join("", [
        for f in fileset("${path.root}/../services/jenkinswatcher", "**") : filesha1("${path.root}/../services/jenkinswatcher/${f}")
      ])
    )
  }

  provisioner "local-exec" {
    command = <<EOT
set -euo pipefail

minikube start --driver=docker

docker build -t jenkinswatcher:dev ${path.root}/../services/jenkinswatcher

minikube image load jenkinswatcher:dev --profile tf-minikube-cluster
EOT
  }
}
