require php.inc

PR = "${INC_PR}.0"

SRC_URI += "file://acinclude-xml2-config.patch \
            file://php-m4-divert.patch"

SRC_URI_append_pn-php += " file://iconv.patch \
            file://imap-fix-autofoo.patch \
            file://pear-makefile.patch \
            file://phar-makefile.patch \
            file://php_exec_native.patch \
            "

SRC_URI[md5sum] = "25ae23a5b9615fe8d33de5b63e1bb788"
SRC_URI[sha256sum] = "e12db21c623b82a2244c4dd9b06bb75af20868c1b748a105a6829a5acc36b287"
