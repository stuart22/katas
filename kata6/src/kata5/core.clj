(ns kata5.core
  (:require [compojure.core :refer :all]
            [ring.middleware.defaults :refer :all]
            [org.httpkit.server :refer [run-server]]
            [clojure.tools.cli :refer :all]
            [clojure.string :as str]
            [clojure.pprint]
            [clojure.java.jdbc :as jdbc]
            [java-jdbc.sql :as sql])
  (:gen-class))

(declare visitor portnum vis-log)



;(korma/defdb db (korma/postgres db-spec))

;(korma/defdb prod (korma/postgres {:db         "kata5db"
;                                   :user       "postgres"
;                                   :password   "katapass"
;                                   ;; optional keys
;                                   :host       "localhost"
;                                   :port       "5432"
;                                   :delimiters ""}))  




(def pg-db {:subprotocol "postgres"
            :subname     "//localhost:5432/kata5db"
            :user        "postgres"
            :password    "katapass"})


(defn index-page [username]
  (cond (nil? username)
        (concat "<form>\n Helloo ""Stranger"
                "<br> Your name:<br> \n <input type=\"text\" name=arg1>\n</form>")
        (not (bound? #'vis-log))
        (concat

        "<html lang=\"en\">
        <head>

        <meta charset=\"utf-8\">
        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">
        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name=\"description\" content="">
        <meta name=\"author\" content="">
        <link rel=\"icon\" href=\"../../favicon.ico\">

        <title>\"Kata 6\" </title>

        <!-- Bootstrap core CSS -->
        <link href=\"../../dist/css/bootstrap.min.css\" rel=\"stylesheet\">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href=\"../../assets/css/ie10-viewport-bug-workaround.css\" rel=\"stylesheet\">

        <!-- Custom styles for this template -->
        <link href=\"jumbotron-narrow.css\" rel=\"stylesheet\">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>
        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>
        <![endif]-->
        </head>

        <body>

        <div class=\"container\">
        <div class=\"header clearfix\">
        <nav>
        <ul class=\"nav nav-pills pull-right\">
        <li role=\"presentation\" class=\"active\"><a href=\"#\">Home</a></li>
        <li role=\"presentation\"><a href=\"#\">About</a></li>
        <li role=\"presentation\"><a href=\"#\">Contact</a></li>
        </ul>
        </nav>
        <h3 class=\"text-muted\">Project name</h3>
        </div>

        <div class=\"jumbotron\">
        <h1>Hello" username "</h1>
        <p class=\"lead\"> <form>
        Hello Stranger <p> Your name:<br>
        <input type=\"text\" name=arg1>
        </form> </p> </p>
        <p><a class=\"btn btn-lg btn-success\" href=\"#\" role=\"button\">Sign up today</a></p>
        </div>

        <div class=\"row marketing\">
        <div class=\"col-lg-6\">
        <h4>Subheading</h4>
        <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

        <h4>Subheading</h4>
        <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

        <h4>Subheading</h4>
        <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>

        <div class=\"col-lg-6\">
        <h4>Subheading</h4>
        <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

        <h4>Subheading</h4>
        <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>

        <h4>Subheading</h4>
        <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>
        </div>

        <footer class=\"footer\">
        <p>&copy; 2016 Company, Inc.</p>
        </footer>

        </div> <!-- /container -->


        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src=\"../../assets/js/ie10-viewport-bug-workaround.js\"></script>
        </body>
        </html>")

        :else (do
                (clojure.pprint/pprint (str "Username:" username))
                (concat "<form>\n Hellooo " username
                        "<br> Your name:<br> \n <input type=\"text\" name=arg1>\n</form> <br>" vis-log))))


(defn insert-visitor
  [visitor]
  (jdbc/insert! pg-db
                :visitors
                {:name visitor}))



(defn get-visitors [pg-db]
  (jdbc/query pg-db ["select * from public.visitors"]))

;(def vis-log (get-visitors pg-db))

(defroutes myapp
  (GET "/"
       request-map
       (do
         (clojure.pprint/pprint request-map)
         (def visitor (apply str (last (split-at 5 (:query-string request-map)))))
         ;(insert-visitor visitor)
         (index-page visitor)))
  (GET "/jumbotron-narrow.css" []
    "body
    {padding-top: 20px;
     padding-bottom: 20px;}

    .header,
    .marketing,
    .footer
    {padding-right: 15px;
     padding-left: 15px;}

    .header
    {padding-bottom: 20px;
     border-bottom: 1px solid #e5e5e5;}


    .header h3
    {margin-top: 0;
     margin-bottom: 0;
     line-height: 40px;}

    .footer {padding-top: 19px;
     color: #777;
     border-top: 1px solid #e5e5e5;}")

  (GET "/css/bootstrap.min.css" []
    "---
    layout: default
    title: CSS
    slug: css
    lead: \"Global CSS settings, fundamental HTML elements styled and enhanced with extensible classes, and an advanced grid system.\"
    ---


    {% include css/overview.html %}
    {% include css/grid.html %}
    {% include css/type.html %}
    {% include css/code.html %}
    {% include css/tables.html %}
    {% include css/forms.html %}
    {% include css/buttons.html %}
    {% include css/images.html %}
    {% include css/helpers.html %}
    {% include css/responsive-utilities.html %}
    {% include css/less.html %}
    {% include css/sass.html %}"))


(defn -main [& port]
  (do
    (print (str "Starting server on port " (last port)))
    (def portnum (last port))

    (run-server myapp {:port (read-string portnum)})))

