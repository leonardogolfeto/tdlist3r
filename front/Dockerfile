# Estagio 1 - Será responsavel em construir nossa aplicação
FROM node:10.13 as node
WORKDIR /app
COPY package.json /app/
RUN npm i npm@latest -g
RUN npm install
RUN npm install -g @angular/cli 
COPY ./ /app/
ARG env=prod
RUN ng build --prod


FROM nginx:1.14
COPY --from=node /app/dist/todo-front /usr/share/nginx/html
COPY ./nginx-custom.conf /etc/nginx/conf.d/default.conf