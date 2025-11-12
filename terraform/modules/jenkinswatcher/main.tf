resource "kubernetes_deployment" "jenkins-deployment" {
  metadata {
    name = "jenkinswatcher"
    namespace = var.namespace
    labels = {
      app = "jenkinswatcher"
    }
  }

  spec {
    replicas = var.replicas
    selector {
      match_labels = {
        app = "jenkinswatcher"
      }
    }
    template {
      metadata {
        labels = {
          app = "jenkinswatcher"
        }
      }
      spec {
        container {
          name = "jenkinswatcher"
          image = "jenkinswatcher:dev"
          port {
            container_port = 8080
          }
          env_from {
            secret_ref {
              name = var.pg_secret.metadata[0].name
            }
          }
          env_from {
            secret_ref {
              name = kubernetes_secret.jenkins_credentials.metadata[0].name
            }
          }
        }
      }
    }
  }
  depends_on = [ null_resource.build_and_load_image, kubernetes_secret.jenkins_credentials ]
}

resource "kubernetes_service" "jenkins-svc" {
  metadata {
    name = "jenkinswatcher-svc"
    namespace = var.namespace
  }

  spec {
    selector = {
      app = "jenkinswatcher"
    }
    port {
      port = 8080
      target_port = 8080
    }
    type = "ClusterIP"
  }
}
