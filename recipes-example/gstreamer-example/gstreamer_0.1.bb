
DESCRIPTION = "simple gstreamer recipe"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://g_example.c"
DEPENDS = "glib-2.0 gstreamer1.0"
RDEPENDS_${PN} = "gstreamer1.0-plugins-base gstreamer1.0-plugins-good"

S = "${WORKDIR}"

do_compile() {
	${CC} g_example.c -o main  `pkg-config --cflags --libs gstreamer-1.0`
	}

do_install(){
	intsall -d ${D}${bindir}/
	install -m 0755 ${S}/main ${D}${bindir}/
}

FILES_${PN} += " \
		${bindir}/ \
	"
