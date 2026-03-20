resource "helm_release" "ingress-nginx" {
  name = "ingress-nginx"
  repository = "https://kubernetes.github.io/ingress-nginx"
  chart = "ingress-nginx"
  namespace = var.namespace

  wait_for_jobs = false
  timeout       = 600
}

resource "kubernetes_service_v1" "viewer_proxy" {
  metadata {
    name = "linkin-viewer-svc-proxy"
    namespace = var.namespace
  }
  spec {
    type = "ExternalName"
    external_name = "${var.viewer_svc.metadata.0.name}.${var.viewer_svc.metadata.0.namespace}.svc.cluster.local"
  }
}

resource "kubernetes_ingress_v1" "gateway" {
  # wait_for_load_balancer = true
  metadata {
    name = "gateway"
    namespace = var.namespace
  }
  spec {
    ingress_class_name = "nginx"
    rule {
      http {
        path {
          path = "/*"
          backend {
            service {
              name = kubernetes_service_v1.viewer_proxy.metadata.0.name
              port {
                number = 80
              }
            }
          }
        }
      }
    }
  }
}
