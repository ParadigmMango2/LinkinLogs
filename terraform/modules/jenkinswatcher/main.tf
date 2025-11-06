resource "kubernetes_deployment" "jenkins-deployment" {
  metadata {
    name = "jenkinswatcher"
    namespace = "jenkins-ns"
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
        }
      }
    }
  }
  depends_on = [ null_resource.build_and_load_image ]
}

resource "kubernetes_service" "jenkins-svc" {
  metadata {
    name = "jenkinswatcher-svc"
    namespace = "jenkins-ns"
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
