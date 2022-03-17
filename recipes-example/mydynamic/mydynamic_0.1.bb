DESCRIPTION = "simple dynamic lib recipe"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://print.c \
	   file://arith.c \
	   file://mylib.h"

S = "${WORKDIR}"

do_compile() {
	${CC} -c -fPIC print.c
	${CC} -c -fPIC arith.c
	${CC} ${LDFLAGS} -shared -Wl,-soname,liblwl.so.1 -o liblwl.so.1.0 *.o
}

do_install(){
	intsall -d ${D}${libdir}
	install -m 0755 liblwl.a ${D}${libdir}
	ln -s liblwl.so.1.0 ${D}${libdir}/liblwl.so.1
	ln -s liblwl.so.1 ${D}${libdir}/liblwl.so
	install -d ${D}${includedir}
	install -m 0644 mylib.h ${D}${includedir}
}


