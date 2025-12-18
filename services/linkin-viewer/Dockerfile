# Build Stage
FROM node:25-alpine AS build
WORKDIR /build
COPY . ./services/linkin-viewer
RUN ls .
WORKDIR /build/services/linkin-viewer
RUN npm install
RUN npm run build

# Run Stage
FROM nginx:alpine
COPY --from=build /build/services/linkin-viewer/dist/linkin-viewer/browser /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
