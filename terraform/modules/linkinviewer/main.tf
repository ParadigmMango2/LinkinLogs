resource "kubernetes_deployment" "linkin-viewer-deployment" {
  metadata {
    name = "linkin-viewer"
    namespace = var.namespace
    labels = {
      app = "linkin-viewer"
    }
  }

  spec {
    replicas = var.replicas
    selector {
      match_labels = {
        app = "linkin-viewer"
      }
    }
    template {
      metadata {
        labels = {
          app = "linkin-viewer"
        }
      }
      spec {
        container {
          name = "linkin-viewer"
          image = "linkin-viewer:dev"
          port {
            container_port = 80
          }
        }
      }
    }
  }
  depends_on = [ null_resource.build_and_load_image ]
}

resource "kubernetes_service" "linkin-viewer-svc" {
  metadata {
    name = "linkin-viewer-svc"
    namespace = var.namespace
  }

  spec {
    selector = {
      app = "linkin-viewer"
    }
    port {
      port = 80
      target_port = 80
    }
    type = "ClusterIP"
  }
}
