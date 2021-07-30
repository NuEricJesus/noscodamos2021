(ns noscodamos2021.core)

(def cliente {
              :nome  "Eric Jesus",
              :cpf   "12345678901",
              :email "eric.jesus@nubank.com.br"
              })

(def cartao {
             :numero   "1234 5678 1234 5678",
             :cvv      355,
             :validade "12/22",
             :limite   1000
             })

(def compras [
              {
               :data            "12/05/2021"
               :valor           50.22
               :estabelecimento "Burguer King"
               :categoria       "Alimentos"
               },
              {
               :data            "12/03/2021"
               :valor           500.29
               :estabelecimento "Casas bahia"
               :categoria       "Móveis"
               },
              {
               :data            "12/02/2021"
               :valor           30.40
               :estabelecimento "Picpay"
               :categoria       "Pagamentos"
               },
              {
               :data            "15/02/2021"
               :valor           20.10
               :estabelecimento "RecargaPay"
               :categoria       "Pagamentos"
               },
              {
               :data            "10/04/2021"
               :valor           100.44
               :estabelecimento "Ponto frio"
               :categoria       "Móveis"
               }
              ])

(println "Dados do cliente:"  cliente)
(println "Dados do cartão:" cartao)
(println "Dados de compras:" compras)

(defn categoria-agrupada
    [compra]
    (->> compra
         (group-by :categoria)))

(defn preco-compra [compra]
  (:valor compra) )

(defn total-compras-categoria
  [compras]
  (reduce + (map preco-compra compras)))

(defn total-categoria
  [[categoria compras]]
  (println categoria ": R$ " (total-compras-categoria compras)) )

(defn exibe-total-categoria
      []
      (map total-categoria (agrupa-categoria compras)))

(println "Total gasto por categoria:")
(exibe-total-categoria)