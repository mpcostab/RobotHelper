/**
 * @author Yaman Tecnologia LTDA
 * @version 1.0
 */
public class SeleniumRobot{
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    /**
     * Espera implicita do driver em execução
     * Utilize caso você precise aguardar por um determinado periodo na tela.
     *
     * @param timeOut Tempo em SEGUNDOS que deseja realizar a espera
     */
    public static void implicitlyWait(Long timeOut) {

        webDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    /**
     * Espera uma lista de elemento ser visivel
     * Utilize caso você precise aguardar uma lista de elementos na tela.
     *
     * @param elements Lista de elementos que devem ser exibidos.
     */
    public static void explicityAllWait(List<WebElement> elements) {

        wait.until(ExpectedConditions.visibilityOfAllElements(elements));

    }

    /**
     * Espera o elemento ser clicavel
     * Utilize caso você precise aguardar um elemento estar clicavel na tela.
     *
     * @param element Elemento que você deseja clicar.
     */
    public static void waitElementoTobeClick(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    /**
     * Verifica se existe um elemento na tela.
     * Utilize caso você precise verificar se existe em elemento na tela.
     *
     * @param xpath Xpath do elemento que você deseja verificar.
     * @return true or false
     */
    public static boolean existElementWebByXpath(String xpath) {

        return webDriver.findElements(By.xpath(xpath)).size() != 0;

    }

    /**
     * Simulação de double click.
     * Utilize caso você precise realizar a ação de double click em um elemento.
     *
     * @param element Elemento que irá receber o Double Click.
     */
    public static void doubleClickWeb(WebElement element) {
        Actions DoubleClick = new Actions(webDriver);
        DoubleClick.doubleClick(element).perform();
    }

    /**
     * Realiza foco no elemento e insere o texto.
     * Utilize caso você precise realizar a ação de focar em um elemento e inserir um texto.
     *
     * @param element Elemento que deseja focar e inserir o texto.
     * @param texto Texto que irá inserir no campo.
     */
    public static void setFocusAndWrite(WebElement element, String texto) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(texto).build().perform();
    }

    /**
     * Simulação de mover o mouse até o elemento.
     * Utilize caso você precise realizar a ação de mover o mouse até um elemento especifico.
     *
     * @param element Elemento que o mouse deve encontrar e se mover até o mesmo.
     */
    public static void moveToElementWeb(WebElement element) {
        Actions MoveToElement = new Actions(webDriver);
        MoveToElement.moveToElement(element).perform();
    }

    /**
     * Verifica se existe um elemento na tela.
     * Utilize caso você precise verificar se existe em elemento na tela.
     *
     * @param element Elemento elemento que você deseja verificar.
     */
    public static void waitElementExistsByWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Retorna a quantidade de elementos na tela.
     * Utilize caso você precise verificar quantos elementos possuem na tela.
     * @param element Xpath dos possíveis elementos existentes na tela.
     * @return quantidade de elementos existentes.
     */
    public static int countElements(String element) {
        return webDriver.findElements(By.xpath(element)).size();
    }

    /**
     * Espera o elemento ser invisível
     * Utilize caso você precise aguardar o elemento sumir(desaparecer) da tela.
     * @param element Elemento que deve sumir da tela.
     */
    public static void waitElementInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Espera o elemento invisivel ser clicavel.
     * Utilize caso você precise aguardar um elemento aparecer na tela e ser clicavel.
     *
     * @param xpath Xpath do elemento que você deseja verificar.
     */
    public static void waitElementInvisible(String xpath) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    /**
     * Simulação de rolagem na tela.
     * Utilize caso você precise simular uma rolagem(scroll) na tela.
     * @param rolagem Quantidade de rolagem que deseja realizar. 0 = topo da tela.
     */
    public static void scroll(int rolagem) {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollBy(0," + rolagem + ")", "");
    }

    /**
     * Simulação de rolagem na tela até o elemento existir.
     * Utilize caso você precise simular uma rolagem(scroll) até o elemento existir na tela.
     * @param xpath Elemento que deseja visualizar na tela.
     */
    public static void scrollElement(String xpath){
        try {
            do {
                ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(" + 100 + "," + 1000 + ");");
                TimeUnit.SECONDS.sleep(3);
            } while (!SeleniumRobot.existElementWebByXpath(xpath));

        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * Realiza clique no elemento através do Java Script da tela.
     * Utilize caso você precise realizar outra forma de clique no elemento.
     * @param elemento Elemento que irá receber o clique.
     */

    public static void clickElementByJavaScript(WebElement elemento){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", elemento);
    }

    /**
     * Realiza clique no link através do texto do link
     * Utilize caso você precise realizar o clique em um link através do texto.
     * @param texto Texto do link que você deseja clicar.
     */
    public static  void clickLinkByText(String texto){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\""+texto+"\"]")));
        webDriver.findElement(By.xpath("//a[text()=\""+texto+"\"]")).click();
    }


    /**
     * Realiza clique em botão pelo texto existente no mesmo.
     * Utilize caso você necessite clicar em um botão existente na tela pelo texto contido no mesmo.
     * @param texto Texto do botão.
     */
    public static void clickButtonByText(String texto){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='"+texto+"']")));
        webDriver.findElement(By.xpath("//input[@value='"+texto+"']")).click();
    }

}
