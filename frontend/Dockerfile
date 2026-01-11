#FROM nginx:alpine
# #Remove default broken config
#RUN rm /etc/nginx/conf.d/default.conf
#
## Copy Angular build
#COPY dist/frontend/browser /usr/share/nginx/html
#
## Copy nginx config
#COPY default.conf /etc/nginx/conf.d/default.conf
#
#EXPOSE 80
#
#CMD ["nginx", "-g", "daemon off;"]
##################Two stage

# =========================
# Stage 1: Build Angular
# =========================
FROM node:20-alpine AS builder

WORKDIR /app

COPY package*.json ./
RUN npm ci

COPY . .

# Production build
RUN npm run build -- --configuration production --base-href /


# =========================
# Stage 2: Nginx
# =========================
FROM nginx:alpine

# Remove default config
RUN rm /etc/nginx/conf.d/default.conf

# SPA + API config
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copy Angular build
COPY --from=builder /app/dist/frontend/browser /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]


