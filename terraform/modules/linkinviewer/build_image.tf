resource "null_resource" "build_and_load_image" {
  triggers = {
    src_hash = sha1(
      join("", [
        for f in fileset("${path.root}/../services/linkin-viewer", "**") : filesha1("${path.root}/../services/linkin-viewer/${f}")
      ])
    )
  }

  provisioner "local-exec" {
    command = <<EOT
set -euo pipefail

minikube start --driver=docker

docker build -t linkin-viewer:dev ${path.root}/../services/linkin-viewer

minikube image load linkin-viewer:dev --profile tf-minikube-cluster
EOT
  }
}
