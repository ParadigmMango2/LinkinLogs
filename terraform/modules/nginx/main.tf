resource "kubernetes_deployment" "nginx" {
  metadata {
    name = var.name
    namespace = "nginx-ns"
    labels = {
      app = var.name
    }
  }

  spec {
    replicas = var.replicas
    selector {
      match_labels = {
        app = var.name
      }
    }
    template {
      metadata {
        labels = {
          app = var.name
        }
      }
      spec {
        container {
          name  = var.name
          image = "nginx:latest"
          port {
            container_port = 80
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "nginx" {
  metadata {
    name = "${var.name}-svc"
    namespace = "nginx-ns"
  }

  spec {
    selector = {
      app = var.name
    }
    port {
      port        = 80
      target_port = 80
    }
    type = "ClusterIP"
  }
}
