require recipes-core/images/core-image-minimal.bb
IMAGE_INSTALL_append = " usbutils"
IMAGE_INSTALL += "myhello"
