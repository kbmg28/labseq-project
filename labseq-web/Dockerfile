FROM node:20.9.0
WORKDIR /web
RUN npm install -g @angular/cli@latest
COPY package.json package-lock.json ./
RUN npm ci
COPY . .
EXPOSE 4200
CMD ["ng", "serve"]
