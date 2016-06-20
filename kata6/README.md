# kata5

0.) Runs a webserver on a port specified when the program is launched
1.) Shows a webpage (at http://localhost:<some_port>) showing a header “Hello Stranger”, an empty text box, and a submit button
2.) When the user ‘submits’ something in the text box, shows the same page as before, but with “Hello <text>” in the header
3.) ‘Saves’ the user’s  text entry to a database. If the program is stopped and restarted, the webpage should still show “Hello <text>” from the last submission.  Below the other elements on the webpage (described in1), the page should list all the other entries users have made

## Usage
In terminal:
lein run kata5.core port

User must have PostgreSQL installed.

## License

Copyright © 2016

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
