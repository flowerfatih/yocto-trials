
DESCRIPTION = "simple static lib recipe"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://print.c \
	   file://arith.c \
	   file://mylib.h"

S = "${WORKDIR}"

do_compile() {
	${CC} -c print.c
	${CC} -c arith.c
	${AR} rcs liblwl.a print.o arith.o
}

do_install(){
	intsall -d ${D}${libdir}
	install -m 0755 liblwl.a ${D}${libdir}
	install -d ${D}${includedir}
	install -m 0644 mylib.h ${D}${includedir}
}
