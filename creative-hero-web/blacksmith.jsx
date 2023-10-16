"use client"

import Container from "@/components/Container";
import Image from 'next/image'
import { motion } from "framer-motion";

const variants = {
  initial: {
    opacity: 0,
  },
  animate: {
    opacity: 1,
    transition: {
      staggerChildren: 0.3,
    },
  },
}

const item = {
  initial: {
    opacity: 0,
    y: 50,
  },
  animate: {
    opacity: 1,
    y: 0,
    transition: {
      duration: 0.5,
      ease: "easeOut",
    },
  },
}

const styles = {
    monoFonts: "text-center text-lg md:text-2xl",
    bottomFooter: "text-center text-sx md:text-sm"
}

const Hero = () => { 

    return (
      <Container>
        <div className="my-14 md:my-10 text-white">
          <motion.div
            initial={{ opacity: 0, scale: 0.9}}
            animate={{ opacity: 1, scale: 1 }}
            transition={{ duration: 1, ease: "easeOut"}}
          >
            <Image
              width={1172}
              height={100}
              src="/images/hero-logo.webp"
              alt="Hero Logo"
              loading="eager"
            />
          </motion.div>

          <motion.div
            variants={variants}
            initial="initial"
            animate="animate"
            transition={{ duration: 0.4, delay: 0.1, ease: "easeOut" }}
            className="-mt-10 md:-mt-20 flex flex-col gap-2 md:flex md:flex-row justify-between relative items-center mb-5 md:mb-10  font-mono"
          >
            <motion.div variants={item}>
              <p className={styles.monoFonts}>SEPTEMBER 18, 2023</p>
            </motion.div>
            <motion.div variants={item} className={styles.monoFonts}>
              <p>9.00 AM - 1.00 PM</p>
            </motion.div>
            <motion.div variants={item} className={styles.monoFonts}>
              <p>C2 - 002, NSBM GREEN UNIVERSITY</p>
            </motion.div>
          </motion.div>
        </div>
      </Container>
    );
}

export default Hero;
