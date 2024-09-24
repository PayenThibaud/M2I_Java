FROM node:alpine

WORKDIR /app

COPY . /app

RUN npm install -g @angular/cli

RUN npm install

ENV NODE_OPTIONS=--openssl-legacy-provider

CMD ["ng","serve","--host","0.0.0.0"]

#docker build -t nom-de-l-image .

