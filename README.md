# quil-unfolding

A Quil sketch with Unfolding.

# Setup

Download

- http://unfoldingmaps.org/downloads
- http://glgraphics.sourceforge.net/#download

and copy them into `lib` and then run

    $ lein localrepo install lib/unfolding.0.9.6.jar unfolding 0.9.6
    $ lein localrepo install lib/GLGraphics.jar glgraphics 1.0.0
    $ lein deps

## Usage

LightTable - open `core.clj` and press `Ctrl+Shift+Enter` to evaluate the file.

Emacs - run cider, open `core.clj` and press `C-c C-k` to evaluate the file.

REPL - run `(require 'quil-unfolding.core)`.

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
